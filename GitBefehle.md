# GIT BEFEHLE

## Erstellen von ssh-Key

```bash

$ ssh-keygen -t -rsa -b 4096 -C "E-Mail"	//erstellen von ssh-Key
$ eval $(ssh-agent -s)						//Key-Agent starten

$ clip < ~/.ssh/id_rsa.pub					//ssh-key kopieren und auf github.com einf�gen

```

## Erstellen von Repository

```bash

$ git init 

```

## Hochladen von Dateien

```bash

$ git add .						//Vorbereitung f�r commit bzw staging
$ git status					//Zeigt �nderungen und was commited werden soll
$ git commit -m "commit msg"	//Snapshot wird erstellt und wird im n�chsten push hochgeladen
$ git push						//Hochladen der Snapshots

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