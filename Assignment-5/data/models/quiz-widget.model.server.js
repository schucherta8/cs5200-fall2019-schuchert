const mongoose = require('mongoose');
const quizWidgetSchema = require('./quiz-widget.schema.server');
mongoose.model('QuizWidgetModel',quizWidgetSchema);