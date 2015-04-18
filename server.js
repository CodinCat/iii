var tty = require('tty.js');

var app = tty.createServer({
  shell: 'bash',
  users: {
    //foo: 'bar'
  },
  port: process.env.PROT
});

app.get('/', function(req, res, next) {
  tty.static(__dirname + 'static/index.html');
});

app.listen();