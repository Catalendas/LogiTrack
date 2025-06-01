import { z } from "zod";
import "dotenv/config"

const envSchema = z.object({
    NODE_ENV: z.enum(["development", "test", "production"]).default("production"),
    PORT: z.number().default(3333)
})

const _env = envSchema.safeParse(process.env)

if (_env.success === false) {
    console.log("⚠ Invalid envioriment variables", _env.error.format())

    throw new Error("Invalid envioriment variables")
}

export const env = _env.data