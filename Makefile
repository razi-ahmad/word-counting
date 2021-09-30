###############
#    Docker
###############
dc-up:
	docker-compose up -d
dc-down:
	docker-compose down
dc-restart: dc-down dc-up

dc-build:
	docker-compose build word-count

dc-build-up: dc-build dc-up