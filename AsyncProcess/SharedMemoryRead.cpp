#include <iostream>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
using namespace std;

int main()
{
	// ftok to generates key
	key_t key = ftok("shmfile", 65);

	// shmget gets an identifier in shid
	int shid = shmget(key, 1024, 0666 | IPC_CREAT);

	// shmat to attach to memory
	char* str = (char*)shmat(shid, (void*)0, 0);

	printf("Data read from memory: %s\n", str);

	//detach from memory
	shmdt(str);

	// destroy the memory
	shmctl(shid, IPC_RMID, NULL);

	return 0;
}
