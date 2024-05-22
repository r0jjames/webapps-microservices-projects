### Github Project Config
`https://github.com/r0jjames/project-config`

### To access the config server properties
ACCOUNTS <br />
accounts.yml: `http://localhost:8071/accounts/default`
accounts-qa.yml: `http://localhost:8071/accounts/qa`
accounts-prod.yml: `http://localhost:8071/accounts/prod`

### To run rabbitmq in Docker
`docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management`
### To access actuator health
Dependency: RabbitMq
`http://localhost:8071/actuator/health`
`http://localhost:8071/actuator/health/liveness`
`http://localhost:8071/actuator/health/readiness
### To use Spring cloud monitor via Git Webhook in localhost
###
Instructions
- Setup hookdeck console(https://console.hookdeck.com/) to test Spring cloud monitor in localhost
- Get event url from hookdeck then add as webhook in Git
- Modify config in the config server
- call actuator/busrefresh
- check hookdeck console and git webhook

------ Hook deck Configuration Setup ------

`
hookdeck login --cli-key 1ss0tf3x25yllzaomc2uwym03f4m65kyxfrn75z528caz7bmlu                                                                      ─╯
> The Hookdeck CLI is configured with your console Sandbox

hookdeck listen 8071 Source                                                                                                                      ─╯
🚩 Not connected with any account. Creating a guest account...
? What path should the events be forwarded to (ie: /webhooks)? /monitor
? What's your connection label (ie: My API)? localhost

Dashboard
👤 Console URL: https://api.hookdeck.com/signin/guest?token=0cxvvfs0u4tcjgpew3kqnwfv0wd8omnjo7skq7q9yg03q4vx04
Sign up in the Console to make your webhook URL permanent.

source Source
🔌 Event URL: https://hkdk.events/tne95mu18629gc

Connections
localhost forwarding to /monitor

> Ready! (^C to quit)
`