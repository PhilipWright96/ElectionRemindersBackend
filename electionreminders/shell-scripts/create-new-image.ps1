param (
    [string]$Target
)

Remove-Item "election_reminders.tar" -Force
mvn clean package
docker compose up -d --build
docker save -o election_reminders.tar electionreminders-app:latest
scp election_reminders.tar $Target