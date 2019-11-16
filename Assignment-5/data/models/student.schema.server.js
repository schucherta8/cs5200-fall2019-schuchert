const mongoose = require('mongoose');//Load modules

//Define a schema. The Schema allows you to define the fields stored in each document along with their validation
// requirements and default values.
const studentSchema = mongoose.Schema({
    _id: Number,
    gradYear: Number,
    scholarship: Number
},{collection: 'students'});
module.exports = studentSchema;//Make this schema publicly available to use in other files.
