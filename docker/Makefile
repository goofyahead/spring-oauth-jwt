#!make

# .PHONY targets are not files
.PHONY: start test coverage stop logs clean rebuild build up down install i nuke lint server
.EXPORT_ALL_VARIABLES:

start:
	docker-compose up

down:
	docker-compose down --rmi local

docker-build:
	docker-compose build

docker-clean:
	docker container prune
	docker image prune -a

build: down project-build docker-build

go: build start

project-build:
	cd ../auth-server && ./gradlew build
	cd ../user-service && ./gradlew build
	cd ../gateway-service && ./gradlew build