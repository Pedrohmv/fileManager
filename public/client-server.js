#!/bin/env node
//  OpenShift sample Node application
var express = require('express');
var fs      = require('fs');
var path = require('path');
var server_port = 8080
var server_ip_address = '127.0.0.1'

// Main application.
var app = express();

app.get('/', function (req, res) {  
  res.sendfile('./html/index.html');
});

// Seting static files path
app.use('/assets/html', express.static(__dirname + '/html/'));
app.use('/assets/css', express.static(__dirname + '/css/'));
app.use('/assets/js', express.static(__dirname + '/js/'));
app.use('/assets/fonts', express.static(__dirname + '/fonts/'));
app.use('/assets/images', express.static(__dirname + '/images/'));

app.use(function(req, res, next) {
	res.setHeader('Access-Control-Allow-Origin', '*');
	res.setHeader('Access-Control-Allow-Methods', 'GET, POST');
	res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type, Authorization');
	//req.setHeader('Authorization');
	next();
});

// Start listening.
app.listen(server_port, server_ip_address, function(){
  console.log("Listening on " + server_ip_address + ", server_port " + server_port)
});