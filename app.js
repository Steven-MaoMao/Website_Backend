const express = require("express")
const mysql = require("mysql")

const app = express()

var message = {};
var rows = {};
var page;

app.use(function (req, res, next) {
	res.header("Access-Control-Allow-Origin", "*");
	res.header('Access-Control-Allow-Methods', 'PUT, GET, POST, DELETE, OPTIONS');
	next();
})

app.get("/getmessage", (req, res, next) => {
	var connection = mysql.createConnection({
		host: "localhost",
		user: "root",
		password: "201018",
		port: "3306",
		database: "WebSite",
	});
	connection.connect();

	var sql = "select count(*) as num from MessageBoard;";
	connection.query(sql, function (err, result) {
		if (err) {
			console.log("[database select error (num)] - ", err.message);
			return;
		}
		rows = result;

		page = req.query.page;
		if (!(page >= 1 && page <= Math.ceil(rows[0].num / 10))) {
			page = 1;
		}

		next();
	});

	connection.end();
})

app.get("/getmessage", (req, res) => {
	var connection = mysql.createConnection({
		host: "localhost",
		user: "root",
		password: "201018",
		port: "3306",
		database: "WebSite",
	});
	connection.connect();

	var sql = "select MessageBoard.id as m_id, MessageBoard.name as m_name, MessageBoard.message as m_message, DATE_FORMAT(MessageBoard.time, '%Y-%m-%d %H:%i:%s') as m_time, MessageComment.id as c_id, MessageComment.name as c_name, MessageComment.comment as c_comment, DATE_FORMAT(MessageComment.time, '%Y-%m-%d %H:%i:%s') as c_time, MessageComment.parent as c_parent from MessageBoard left join MessageComment on MessageBoard.id=MessageComment.parent where MessageBoard.id<=((select max(id) from MessageBoard)-" + String((page - 1) * 10) + ") and MessageBoard.id>=((select max(id) from MessageBoard)-" + String((page - 1) * 10 + 9) + ") order by m_id desc, c_id desc;";
	connection.query(sql, function (err, result) {
		if (err) {
			console.log("[database select error] - ", err.message);
			return;
		}
		messages = result;

		messages.push(rows[0]);
		res.send(messages);
	});

	connection.end();
})

app.get("/sendmessage", (req, res) => {
	var connection = mysql.createConnection({
		host: "localhost",
		user: "root",
		password: "201018",
		port: "3306",
		database: "WebSite",
	});
	connection.connect();

	var sql = "insert into MessageBoard (name, message, time) values (?, ?, now());";
	var sqlParams = [req.query.name, req.query.message];
	connection.query(sql, sqlParams, function (err, result) {
		if (err) {
			console.log("[database insert error] - ", err.message);
			return;
		}
	});

	connection.end();
})

app.get("/sendcomment", (req, res) => {
	var connection = mysql.createConnection({
		host: "localhost",
		user: "root",
		password: "201018",
		port: "3306",
		database: "WebSite",
	});
	connection.connect();

	var sql = "insert into MessageComment (name, comment, time, parent) values (?, ?, now(), ?);";
	var sqlParams = [req.query.name, req.query.comment, req.query.parent];
	connection.query(sql, sqlParams, function (err, result) {
		if (err) {
			console.log("[database insert error] - ", err.message);
			return;
		}
	});

	connection.end();
})

app.listen(5600)
