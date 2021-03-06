// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

/** Fetches the current date from the server and adds it to the page. */
async function helloWorld() {
  const responseFromServer = await fetch('/hello');
  const textFromResponse = await responseFromServer.text();

  const textContainer = document.getElementById('hello-world');
  textContainer.innerText = textFromResponse;
}

async function getGreetings() {
  const responseFromServer = await fetch('/hello');
  // The json() function returns an object that contains fields that we can
  // reference to create HTML.
  const greetingItems = await responseFromServer.json();

  const greetingsListElement = document.getElementById('hello-world');
  greetingsListElement.innerHTML = '';

  console.log("Entered list");
  greetingsListElement.appendChild(
      createListElement('English: ' + greetingItems.enGreeting));
  greetingsListElement.appendChild(
      createListElement('Spanish: ' + greetingItems.spGreeting));
  greetingsListElement.appendChild(
      createListElement('Chinese: ' + greetingItems.cnGreeting));
  greetingsListElement.appendChild(
      createListElement('French: ' + greetingItems.fraGreeting));
}

/** Creates an <li> element containing text. */
function createListElement(text) {
  const liElement = document.createElement('li');
  liElement.innerText = text;
  return liElement;
}