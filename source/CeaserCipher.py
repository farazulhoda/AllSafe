import tkinter as tk

def caesar_cipher(text, shift):
    cipher_text = ""
    for char in text:
        if char.isalpha():
            ascii_val = ord(char)
            shifted_ascii_val = ascii_val + shift
            if char.islower():
                if shifted_ascii_val > ord('z'):
                    shifted_ascii_val = ord('a') + (shifted_ascii_val - ord('z')) - 1
                cipher_text += chr(shifted_ascii_val)
            else:
                if shifted_ascii_val > ord('Z'):
                    shifted_ascii_val = ord('A') + (shifted_ascii_val - ord('Z')) - 1
                cipher_text += chr(shifted_ascii_val)
        else:
            cipher_text += char
    return cipher_text

def encrypt():
    text = text_entry.get("1.0", "end-1c")
    shift = int(shift_entry.get())
    cipher_text = caesar_cipher(text, shift)
    output_label.configure(text=cipher_text)

window = tk.Tk()
window.title("Caesar Cipher")

text_label = tk.Label(text="Enter text to encrypt:")
text_label.pack()

text_entry = tk.Text(width=50, height=10)
text_entry.pack()

shift_label = tk.Label(text="Enter shift value:")
shift_label.pack()

shift_entry = tk.Entry()
shift_entry.pack()

encrypt_button = tk.Button(text="Encrypt", command=encrypt)
encrypt_button.pack()

output_label = tk.Label(text="")
output_label.pack()

window.mainloop()