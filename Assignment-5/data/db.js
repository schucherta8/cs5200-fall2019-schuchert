module.exports = function () {
    const mongoose = require('mongoose');
    mongoose.set('useUnifiedTopology', true);
    const databaseName = 'whiteboard';
    var connectionString = 'mongodb://localhost:27017/';
    connectionString += databaseName;
    mongoose.connect(connectionString,{useNewUrlParser: true});
};

