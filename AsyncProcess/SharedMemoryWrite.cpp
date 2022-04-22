#include <iostream>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
using namespace std;

int main()
{
	// ftok to generate special key
	key_t key = ftok("shmfile", 65);

	// shmget gets the identifier in shid
	int shid = shmget(key, 1024, 0666 | IPC_CREAT);

	// shmat adds to shared memory
	char* stg = (char*)shmat(shid, (void*)0, 0);

	cout << "Write Data : ";
	gets(stg);

	printf("Data written in memory: %s\n", stg);

	//detach from shared memory
	shmdt(stg);

	return 0;
}
