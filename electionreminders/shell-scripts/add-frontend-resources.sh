#!/bin/bash

cd admin-frontend
npm run build
cp -r dist/* ../src/main/resources/static/dashboard