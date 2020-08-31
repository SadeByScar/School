# GIT BEFEHLE

## Erstellen von ssh-Key

```bash

//erstellen von ssh-Key
$ ssh-keygen -t -rsa -b 4096 -C "E-Mail"
//Key-Agent starten	
$ eval $(ssh-agent -s)
//Key hinzufügen						
$ ssh-add path/to/private/key
//ssh-key kopieren und auf github.com einfügen				
$ clip < ~/.ssh/id_rsa.pub					

```

## Einrichtung von GIT

```bash

//Setzten des Benutzernamen und der E-Mail des Nutzers
$ git config --gloabl user.name "Name"
$ git config --global user.email "Email"

```

## Erstellen von Repository

```bash

//Erstellen des Repositories
$ git init

```

## Hochladen von Dateien

```bash

//Vorbereitung für commit bzw staging
$ git add .						
//Zeigt Änderungen und was commited werden soll
$ git status	
//Snapshot wird erstellt und wird im nächsten push hochgeladen				
$ git commit -m "commit msg"
//Hochladen der Snapshots	
$ git push						

```

## Repository runterladen

* Erstes mal runterladen 

```bash

$ git clone git@github.com:username/Repository.git

```

* Updates runterladen

```bash

$ git pull

```