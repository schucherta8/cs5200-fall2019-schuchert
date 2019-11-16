const mongoose = require('mongoose');
const questionSchema = require('./question.schema.server');
const quizWidgetSchema = mongoose.Schema({//One to many
    _id: Number,
    questions: [{
        type: mongoose.Schema.ObjectID,
        ref: 'QuestionModel'
    }]
},{collection:'question-widgets'});
module.exports = quizWidgetSchema;