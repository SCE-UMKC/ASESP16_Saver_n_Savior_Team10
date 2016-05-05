var client = require('./client');

var call = {
  triggerCall: function(reminder) {
	  console.log(reminder.user.phone);
    return client.makeCall({
      to: reminder.user.phone,
      from: '+12014686307',
      url: 'http://892c78ac.ngrok.io/call/twiml/' + reminder.user._id + '/' + reminder._id
    }, function(error, response) {
      console.log(error || response);
    });
  }
}

module.exports = call;
