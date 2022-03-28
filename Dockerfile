FROM nginx:1.19.8

COPY main.html /data/www/
COPY businesscard.conf /etc/nginx.conf/businesscard.conf
COPY nginx.conf /etc/nginx/nginx.conf