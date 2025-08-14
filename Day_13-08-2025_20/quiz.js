let quizData = [
    {
        question: "What is the capital of France?",
        options: ["Paris", "London", "Berlin", "Madrid"],
        answer: "Paris"
    },
    {
        question: "Which is the largest planet in our solar system?",
        options: ["Earth", "Jupiter", "Mars", "Saturn"],
        answer: "Jupiter"
    },
    {
        question: "What is 5 + 3?",
        options: ["5", "8", "10", "12"],
        answer: "8"
    }
];

let currentIndex = 0;
let score = 0;

function loadQuestion() {
    let q = quizData[currentIndex];
    document.getElementById("question").textContent = q.question;
    let optionsDiv = document.getElementById("options");
    optionsDiv.innerHTML = "";

    q.options.forEach(option => {
        let btn = document.createElement("button");
        btn.textContent = option;
        btn.onclick = () => checkAnswer(option);
        optionsDiv.appendChild(btn);
    });

    document.getElementById("feedback").textContent = "";
}

function checkAnswer(selected) {
    let correctAnswer = quizData[currentIndex].answer;
    if (selected === correctAnswer) {
        document.getElementById("feedback").textContent = "Correct!";
        score++;
    } else {
        document.getElementById("feedback").textContent = "Wrong!";
    }
    document.getElementById("score").textContent = score;
}

function nextQuestion() {
    currentIndex++;
    if (currentIndex < quizData.length) {
        loadQuestion();
    } else {
        document.getElementById("question").textContent = "Quiz Completed!";
        document.getElementById("options").innerHTML = "";
        document.getElementById("feedback").textContent = "";
    }
}

loadQuestion();
