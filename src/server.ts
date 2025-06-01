import fastify from "fastify";
import { env } from "./env";

const app = fastify()

app.get("/", async () => {
    
})

app.listen({
    port: env.PORT
}).then(() => { console.log(`Run at port ${env.PORT}`) })