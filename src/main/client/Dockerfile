FROM node:20-alpine

WORKDIR /app

COPY package.json .

RUN npm install

COPY . .

ARG API_URL

ENV VITE_API_URL=${API_URL}

RUN npm run build

RUN npm i serve -g

EXPOSE 5002

CMD [ "serve", "-s", "-p", "5002", "dist" ]