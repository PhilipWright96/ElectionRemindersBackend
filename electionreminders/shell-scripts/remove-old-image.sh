#!/bin/bash

rm election_reminders.tar
docker-compose down
docker system prune -a --volumes