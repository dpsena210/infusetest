FROM node:20-alpine as build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build -- --configuration production

FROM nginx:alpine
COPY --from=build /app/dist/consulta-creditos-frontend/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
