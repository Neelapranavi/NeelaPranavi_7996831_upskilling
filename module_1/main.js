// Welcome Message
console.log("Welcome to the Community Portal");

window.onload = function () {
    alert("Page Fully Loaded");
};

// Event Details
const eventName = "Music Festival";
const eventDate = "10 June 2026";
let availableSeats = 50;

console.log(`Event: ${eventName} | Date: ${eventDate}`);

// Register User
function registerUser() {

    try {

        if (availableSeats <= 0) {
            throw "No seats available";
        }

        availableSeats--;

        document.getElementById("seatCount").innerHTML =
            availableSeats;

        alert("Registration Successful");

    }

    catch (error) {
        alert(error);
    }
}

// Event List
const events = [
    {
        name: "Music Festival",
        category: "Music",
        seats: 10
    },

    {
        name: "Tech Workshop",
        category: "Tech",
        seats: 0
    },

    {
        name: "Food Carnival",
        category: "Food",
        seats: 20
    }
];

// Display Events
events.forEach(event => {

    if (event.seats > 0) {
        console.log(event.name);
    }

});

// Add Event
function addEvent(name, category, seats) {

    events.push({
        name,
        category,
        seats
    });

}

// Filter Events
function filterEventsByCategory(category) {

    return events.filter(
        event => event.category === category
    );

}

// Closure Example
function registrationTracker() {

    let total = 0;

    return function () {

        total++;

        console.log(
            `Total Registrations: ${total}`
        );
    };
}

const countRegistration =
    registrationTracker();

// Event Class
class Event {

    constructor(name, seats) {

        this.name = name;
        this.seats = seats;
    }
}

// Prototype Method
Event.prototype.checkAvailability =
    function () {

        return this.seats > 0 ?
            "Seats Available" :
            "Full";
    };

// Object Entries
const sampleEvent =
    new Event("Dance Show", 25);

console.log(
    Object.entries(sampleEvent)
);

// Map Example
const eventCards =
    events.map(event =>
        `Workshop on ${event.name}`
    );

console.log(eventCards);

// DOM Manipulation
const container =
    document.querySelector("#eventContainer");

events.forEach(event => {

    const card =
        document.createElement("div");

    card.className = "eventCard";

    card.innerHTML = `
        <h3>${event.name}</h3>
        <p>Category: ${event.category}</p>
        <p>Seats: ${event.seats}</p>
    `;

    container.appendChild(card);

});

// Search Function
document.getElementById("searchBox")
    .addEventListener("keydown", function () {

        console.log(
            "Searching..."
        );

    });

// Async Await Example
async function fetchEvents() {

    try {

        document.getElementById("loading")
            .style.display = "block";

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/posts"
            );

        const data =
            await response.json();

        console.log(data);

        document.getElementById("loading")
            .style.display = "none";

    }

    catch (error) {

        console.log(error);

    }
}

// Form Validation
document.getElementById("registerForm")
    .addEventListener("submit",
        function (event) {

            event.preventDefault();

            const name =
                this.elements["name"].value;

            const email =
                this.elements["email"].value;

            if (name === "" || email === "") {

                alert("Please fill all fields");

                return;
            }

            alert("Form Submitted");

        });

// AJAX POST Example
function submitData() {

    const userData = {

        name: "Pranavi",
        event: "Music Festival"
    };

    setTimeout(() => {

        fetch(
            "https://jsonplaceholder.typicode.com/posts",
            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body:
                    JSON.stringify(userData)
            }
        )

            .then(response =>
                response.json()
            )

            .then(data => {

                console.log(data);

                alert("Registration Sent");

            })

            .catch(error => {

                console.log(error);

            });

    }, 2000);

}