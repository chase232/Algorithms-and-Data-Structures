#!/usr/bin/env python3

import sys


def djb2(s):
    hash = 5381 # some prime number
    magic = 33  # magic number that works well
    for c in s:
        hash = hash * magic + ord(c)
    return hash & 0xFFFFFFFF


def main():
    print(djb2("Data Structures’")%10) 
    

if __name__ == '__main__':
    main()
