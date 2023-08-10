const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(bodyParser.json());

app.post('/api/postdata', (req, res) => {
  const data = req.body;
  if (data && data.name) {
    console.log("Hello, %s",  data.name);
    res.status(200).json({ message: `Hello, ${data.name}!` });
  } else {
    res.status(400).json({ error: 'Invalid input' });
  }
});


app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});

