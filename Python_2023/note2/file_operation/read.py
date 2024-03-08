import json
def read_notes():
   
    data = json.load(open("notes.json"))
    for note in data['notes']:
        print(f"ID: {note['id']}\nЗаголовок: {note['title']}\nТекст: {note['body']}\nДата/Время: {note['timestamp']}\n")
