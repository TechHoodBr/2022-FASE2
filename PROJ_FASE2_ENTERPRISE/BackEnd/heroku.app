heroku login
heroku plugins:install java
heroku plugins:install heroku-cli-deploy
heroku deploy:jar target/brq-api-1.0.0-SNAPSHOT.jar --app techhood-brq-api
heroku logs --tail --app techhood-brq-api
