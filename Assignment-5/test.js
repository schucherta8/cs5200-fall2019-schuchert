require('./data/db.js')();

const universityDao = require('./data/daos/university.dao.server');

beforeAll(() => {
    return universityDao.truncateDatabase().then(() => {
        return universityDao.populateDatabase();
    });
});

test('testStudentsInitialCount',() => {
    return universityDao.findAllStudents()
        .countDocuments()
        .then(data => {
            expect(data).toBe(2);
        })
        .catch(err => console.log(err));
});

test('testQuestionsInitialCount', () => {
   return universityDao.findAllQuestions()
       .countDocuments()
       .then(data => {
            expect(data).toBe(4);
       })
       .catch(err => console.log(err));
});

test('testAnswersInitialCount', () => {
   return universityDao.findAllAnswers()
       .countDocuments()
       .then(data => {
           expect(data).toBe(8);
       })
       .catch(err => console.log(err));
});

test('testDeleteAnswer', () => {
    return universityDao.deleteAnswer(890)
        .then(() => {
            universityDao.findAllAnswers().countDocuments()
                .then(output => {
                    expect(output).toBe(7);
                });
            universityDao.findAnswersByStudent(234).countDocuments()
                .then(output => {

                    expect(output).toBe(3);
                });
        })
        .catch(err => console.log(err));
});

test('testDeleteQuestion', () => {
    return universityDao.deleteQuestion(321)
        .then(() => universityDao.findAllQuestions().countDocuments())
        .then(output => {
            expect(output).toBe(3);
        })
        .catch(err => console.log(err));
});

test('testDeleteStudent', () => {
    return universityDao.deleteStudent(234)
        .then(() => universityDao.findAllStudents().countDocuments())
        .then(output => {
            console.log(output);
            expect(output).toBe(1);
        })
        .catch(err => console.log(err))
});

afterAll(() => {
   return universityDao.truncateDatabase();
});

//close connections