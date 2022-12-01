# Version Control - GitHub

## Setup

- Have Git installed on your machine
- A GitHub account

## Activity

This is a short exercise to get you used to using Git to perform simple operation such as: cloning, staging, commiting,
pushing, Pull/Merge Requests and rebasing.

### Creating a new Repository

Locate the + button to create new things at the top right of the screen and click New Repository

![Create new dropdown](resources/new_dropdown.png)

Create a new repository call `git-practice`, add a README and Licence.

![](resources/create_repository.png)

Once you have created your repository it should look something like this.

![](resources/new_respository.png)

### Cloning the Repository

To edit the code in our repository we need to **clone** it. `git clone` create a directory for the code and downloads 
the code from the repository into the new directory. We will now **clone** our new repository.

```shell
git clone git@github.com:{YOUR_GITHUB_USERNAME}/git-practice.git
```

You should see something like this

![](resources/clone.png)

If you move into the newly create directory and check its status. The `git status` command show the current state of 
working tree. Showing files that have been added, modified and deleted.

```shell
cd git-practice
git status
```

![](resources/status_1.png)

### Editing an existing file

Open README.md in you IDE and add some new content the file under the existing content. For example:

```markdown
### About Me

**Name**: Mark Bradley
**Location**: London
**Languages**:
  - PHP
  - Java
  - Golang
```

If you check the status of for local repository

```shell
git status
```

you should have one changed file where the changes have not yet been staged.

If you were to commit at this point nothing would be committed because no of the changes have been staged.

![](resources/status_2.png)

you can see what has been changed by checking the **diff**. It shows all the lines of code we added to our README

```shell
git diff
```

![](resources/diff_1.png)

If we want to commit the change and push it back to GitHub we first have to stage the change using the **add** command
there are few ways we can do this.

The first will stage all un-staged changes 

```shell
git add .
```

This will stage a specific file

```shell
git add README.md
```

or you can check the patch and stage just the change parts you want

```shell
git add -p
```

![](resources/add-p.png)

![](resources/status_3.png)

Now that our change has been stage we can commit our change. we can provide a commit message using the message flag`-m` 

```shell
git commit -m "A short message about our change"
```

or if you leave off the message flag and git will open a text editor for you to add a message the advantage of this way 
is that you can add a multi-line message.

```shell
git commit
```

I recommend you read this [article](https://cloudnative.ly/what-does-a-good-commit-message-look-like-89ba44e364e0) on
What does a good commit message look like.

once you have commited your changes we can now push them up to GitHub

```shell
git push origin main
```

if you remove some of the lines you added to the README and check the diff you can see how git show changes where code 
is removed from a file

![](resources/diff_2.png)

we are not going to keep these changes so we will use the **restore** command to remove the changes we have just made

```shell
git restore README.md
```

### Creating a branch

Sometimes the feature we are working on is going to take a couple of days and we want to commit our changes. We can do 
this using a branch

Branches are TODO

we can create a branch using the **checkout** command using the branch flag `-b`

```shell
git checkout -b add_hobbies
```

edit the README file again to add some hobbie to the bottom of you file something like

```markdown
**Hobbies**:
  - Photography
  - Teaching TDD
  - Cooking
  - Collection CDs
```

Add and commit these changes, but do not push them yet. While we were looking at the file we notice we made some 
mistakes in the MarkDown format and have missed some line breaks. Edit you README so it now look similar to this:

```markdown
### About Me

**Name**: Mark Bradley

**Location**: London

**Languages**:
  - PHP
  - Java
  - Golang

**Hobbies**:
  - Photography
  - Teaching TDD
  - Cooking
  - Collection CDs
```

Add and Commit these changes then push to you new branch

```shell
git push origin add_hobbies  
```

When we push the changes to GitHub it should show a link for us to create a Pull Request. Click this link to create the 
Pull Request.

![](resources/push_1.png)

If the link does not appear when you push you will also see the suggestion to create a Pull Request at the top of the 
repository page on GitHub.

![](resources/create_pr_button.png)

![](resources/create_pr.png)

![](resources/new_pr.png)


