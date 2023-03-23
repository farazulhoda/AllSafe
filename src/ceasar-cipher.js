function encrypt() {
    let plaintext = document.getElementById("input-text").value;
    let shift = parseInt(document.getElementById("shift-key").value);
    let ciphertext = "";

    for (let i = 0; i < plaintext.length; i++) {
        let c = plaintext.charCodeAt(i);
        if (c >= 65 && c <= 90) {
            // uppercase letters
            ciphertext += String.fromCharCode(((c - 65 + shift) % 26) + 65);
        } else if (c >= 97 && c <= 122) {
            // lowercase letters
            ciphertext += String.fromCharCode(((c - 97 + shift) % 26) + 97);
        } else {
            // non-alphabetic characters
            ciphertext += plaintext.charAt(i);
        }
    }

    document.getElementById("output-text").value = ciphertext;
}

function decrypt() {
    let ciphertext = document.getElementById("input-text").value;
    let shift = parseInt(document.getElementById("shift-key").value);
    let plaintext = "";

    for (let i = 0; i < ciphertext.length; i++) {
        let c = ciphertext.charCodeAt(i);
        if (c >= 65 && c <= 90) {
            // uppercase letters
            plaintext += String.fromCharCode(((c - 65 - shift + 26) % 26) + 65);
        } else if (c >= 97 && c <= 122) {
            // lowercase letters
            plaintext += String.fromCharCode(((c - 97 - shift + 26) % 26) + 97);
        } else {
            // non-alphabetic characters
            plaintext += ciphertext.charAt(i);
        }
    }

    document.getElementById("output-text").value = plaintext;
}