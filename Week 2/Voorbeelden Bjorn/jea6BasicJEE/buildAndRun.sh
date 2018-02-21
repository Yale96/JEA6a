#!/bin/sh
mvn clean package && docker build -t nl.fhict.jea/jea6BasicJEE .
docker rm -f jea6BasicJEE || true && docker run -d -p 8080:8080 -p 4848:4848 --name jea6BasicJEE nl.fhict.jea/jea6BasicJEE 
