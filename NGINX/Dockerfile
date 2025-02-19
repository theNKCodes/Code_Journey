FROM node:23-alpine3.19

WORKDIR /app

COPY server.js .
COPY index.html .
COPY images ./images
COPY package.json .

RUN npm install

EXPOSE 3000

CMD [ "node", "server.js" ]
