const input = document.getElementById("password");
const letter = document.getElementById("letter");
const capital = document.getElementById("capital");
const number = document.getElementById("number");
const pwLength = document.getElementById("length");
const form = document.getElementById("form");
const password = document.getElementById("password");
const confirm_password = document.getElementById("senha-confirmacao");

// When the user clicks on the password field, show the message box
function showMessage() {
  document.getElementById("mensagem").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box

function hideMessage() {
  document.getElementById("mensagem").style.display = "none";
}

// When the user starts to type something inside the password field

function validateChars() {
  // Validate lowercase letters
  const lowerCaseLetters = /[a-z]/g;
  if (input.value.match(lowerCaseLetters)) {
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }

  // Validate capital letters
  const upperCaseLetters = /[A-Z]/g;
  if (input.value.match(upperCaseLetters)) {
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  const numbers = /[0-9]/g;
  if (input.value.match(numbers)) {
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  // Validate length
  if (input.value.length >= 8) {
    pwLength.classList.remove("invalid");
    pwLength.classList.add("valid");
  } else {
    pwLength.classList.remove("valid");
    pwLength.classList.add("invalid");
  }
}

// validação senha

function isValidPassword() {
  const numberValid = number.classList.contains("valid");
  const letterValid = letter.classList.contains("valid");
  const capitalValid = capital.classList.contains("valid");
  const pwLengthValid = pwLength.classList.contains("valid");

  return numberValid && letterValid && capitalValid && pwLengthValid;
}

/** APPLY VALIDATIONS */
function validatePassword() {
  if (password.value != confirm_password.value) {
    return confirm_password.setCustomValidity("Senhas diferentes!");
  } else if (!isValidPassword()) {
    return password.setCustomValidity("Senha não segue os padrões!");
  } else {
    password.setCustomValidity("");
    confirm_password.setCustomValidity("");
  }
}

/** TOGGLE PASSWORD VISIBILITY */
function toggleVisible(container) {
  if ($(`${container} input`).attr("type") == "text") {
    $(`${container} input`).attr("type", "password");
    $(`${container} i`).addClass("fa-eye-slash");
    $(`${container} i`).removeClass("fa-eye");
  } else if ($(`${container} input`).attr("type") == "password") {
    $(`${container} input`).attr("type", "text");
    $(`${container} i`).removeClass("fa-eye-slash");
    $(`${container} i`).addClass("fa-eye");
  }
}

input.onfocus = showMessage;
input.onblur = hideMessage;
input.onkeyup = validateChars;
password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;

$("#show_hide_password button").on("click", () => {
  toggleVisible("#show_hide_password");
});

$("#show_hide_confirm_password button").on("click", () => {
  toggleVisible("#show_hide_confirm_password");
});
