# Advanced Java: Threads and Concurrency
This is the repository for the LinkedIn Learning course `Advanced Java: Threads and Concurrency`. The full course is available from [LinkedIn Learning][lil-course-url].

![lil-thumbnail-url]

Are you looking to boost your Java skills? In this course, join instructor and Java expert Buddhini Samarakkody as she provides an overview of Java threads and the new concurrent programming model. Buddhini covers topics in synchronization such as Java thread memory access and associated problems such as race condition and data race. Explore the purpose of synchronization and how to use it, before turning to asynchronous programming with Future and CompletableFuture. Buddhini shows you how to use executors, the fork/join framework and its core classes, concurrent data structures, Project Loom, and virtual threads. Along the way, be sure to test out your new skills in the exercise challenges at the end of each section.

_See the readme file in the main branch for updated instructions and information._
## Instructions
This repository has branches for each of the videos in the course. You can use the branch pop up menu in github to switch to a specific branch and take a look at the course at that stage, or you can add `/tree/BRANCH_NAME` to the URL to go to the branch you want to access.

## Branches
The branches are structured to correspond to the videos in the course. The naming convention is `CHAPTER#_MOVIE#`. As an example, the branch named `02_03` corresponds to the second chapter and the third video in that chapter. 
Some branches will have a beginning and an end state. These are marked with the letters `b` for "beginning" and `e` for "end". The `b` branch contains the code as it is at the beginning of the movie. The `e` branch contains the code as it is at the end of the movie. The `main` branch holds the final state of the code when in the course.

When switching from one exercise files branch to the next after making changes to the files, you may get a message like this:

    error: Your local changes to the following files would be overwritten by checkout:        [files]
    Please commit your changes or stash them before you switch branches.
    Aborting

To resolve this issue:
	
    Add changes to git using this command: git add .
	Commit changes using this command: git commit -m "some message"


[0]: # (Replace these placeholder URLs with actual course URLs)

[lil-course-url]: https://www.linkedin.com/learning/
[lil-thumbnail-url]: https://media.licdn.com/dms/image/D560DAQFM76Oarhc2VA/learning-public-crop_675_1200/0/1712955344085?e=2147483647&v=beta&t=dPEMZnXIX1uXuEz-ILFKUTyjiWKDd0Px7A29okIq6Z0

