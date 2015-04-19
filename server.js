var tty = require('tty.js');

var app = tty.createServer({
  shell: 'bash',
  port: 80
});

app.get('/', function(req, res, next) {
  tty.static(__dirname + 'static/index.html');
});

app.listen();
