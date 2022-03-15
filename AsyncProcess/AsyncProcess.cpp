// CPP program to demonstrate the given task
#include <iostream>
#include <pthread.h>
#include <queue>
#include <stdlib.h>

#define MAX 12

using namespace std;

// Declaring global variables
int sum_B = 0, sum_C = 0;
int consumerCount1 = 0;
int consumerCount2 = 0;

// Shared queue
queue<int> SQ;

// declaration of required functions
void* ranProducer(void*);
void* add_TB(void*);
void* add_TC(void*);

// Getting the mutex
pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;

pthread_cond_t dataNotProduced =
PTHREAD_COND_INITIALIZER;
pthread_cond_t dataNotConsumed =
PTHREAD_COND_INITIALIZER;

// Function to generate random numbers and
// push them into queue using thread A

void* ranProducer(void*)
{
	static int numberCount = 0;

	// Initialising the seed
	srand(time(NULL));

	while (1) {
		// Getting the lock on queue using mutex
		pthread_mutex_lock(&mutex);

		if (SQ.size() < MAX && numberCount < MAX)
		{

			// generating random numbers
			int rNum = rand() % 10 + 1;
			cout << "Produced: " << rNum << endl;

			// Pushing the number into queue
			SQ.push(rNum);

			numberCount++;

			pthread_cond_broadcast(&dataNotProduced);
		}

		// If queue is full, release the lock and return
		else if (numberCount == MAX) {
			pthread_mutex_unlock(&mutex);
			return NULL;
		}

		// If some other thread is executing, wait
		else {
			cout << ">> Producer is in wait.." << endl;
			pthread_cond_wait(&dataNotConsumed, &mutex);
		}

		// Get the mutex unlocked
		pthread_mutex_unlock(&mutex);
	}
}

// Function definition for consumer thread B
void* add_TB(void*)
{

	while (1) {

		// Getting the lock on queue using mutex
		pthread_mutex_lock(&mutex);

		// Pop only when queue has at least 1 element
		if (SQ.size() > 0) {
			// Get the data from the front of queue
			int data = SQ.front();

			cout << "B thread consumed: " << data << endl;

			// Add the data to the integer variable
			// associated with thread B
			sum_B += data;

			// Pop the consumed data from queue
			SQ.pop();

			consumerCount1++;

			pthread_cond_signal(&dataNotConsumed);
		}

		// Check if consumed numbers from both threads
		// has reached to MAX value
		else if (consumerCount2 + consumerCount1 == MAX) {
			pthread_mutex_unlock(&mutex);
			return NULL;
		}

		// If some other thread is executing, wait
		else {
			cout << "B is in wait.." << endl;
			pthread_cond_wait(&dataNotProduced, &mutex);
		}

		// Get the mutex unlocked
		pthread_mutex_unlock(&mutex);
	}
}

// Function definition for consumer thread C
void* add_TC(void*)
{

	while (1) {

		// Getting the lock on queue using mutex
		pthread_mutex_lock(&mutex);

		// Pop only when queue has at least 1 element
		if (SQ.size() > 0) {

			// Get the data from the front of queue
			int data = SQ.front();
			cout << "C thread consumed: " << data << endl;

			// Add the data to the integer variable
			// associated with thread B
			sum_C += data;

			// Pop the consumed data from queue
			SQ.pop();
			consumerCount2++;

			pthread_cond_signal(&dataNotConsumed);
		}

		// Check if consumed numbers from both threads
		// has reached to MAX value
		else if (consumerCount2 + consumerCount1 == MAX)
		{
			pthread_mutex_unlock(&mutex);
			return NULL;
		}

		// If some other thread is executing, wait
		else {
			cout << ">> C is waiting.." << endl;
			// Wait on a condition
			pthread_cond_wait(&dataNotProduced, &mutex);
		}

		// Get the mutex unlocked
		pthread_mutex_unlock(&mutex);
	}
}

// Mein method and entry point for program
int main()
{
	// stating variables used to
	// identify the thread in the program
	pthread_t producerThread, consumerThread1, consumerThread2;

	//creating threads of the
 	// (pthread_create() takes 4 arguments)
	int retProducer = pthread_create(&producerThread,
		NULL, ranProducer, NULL);
	int retConsumer1 = pthread_create(&consumerThread1,
		NULL, *add_TB, NULL);
	int retConsumer2 = pthread_create(&consumerThread2,
		NULL, *add_TC, NULL);

	// pthread_join suspends execution of the calling
	// thread until the target thread terminates
	if (!retProducer)
		pthread_join(producerThread, NULL);
	if (!retConsumer1)
		pthread_join(consumerThread1, NULL);
	if (!retConsumer2)
		pthread_join(consumerThread2, NULL);
	// Checking to know which thread executed more task
	if (consumerCount2 > consumerCount1)
		cout << "Thread C executed more task" << endl;
	else if (consumerCount2 < consumerCount1)
		cout << "Thread B Executed more task" << endl;
	else
		cout << "Both has same score" << endl;

	return 0;
}
