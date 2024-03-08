from datetime import datetime
import json


notes = []
def create_first_note():

    timestamp = datetime.now().strftime('%Y-%m-%d') #%H:%M:%S') 
    note_id = 1 
    note_title = input("Введите заголовок заметки: ")

    note_body = input("Введите текст заметки: ")
    note = {"id": note_id,
            "title": note_title,
            "body": note_body,
            "timestamp": timestamp
    }
    notes.append(note)
    global_note = { "notes": notes }
    with open("notes.json", "w") as file:

        json.dump(global_note, file,indent=4, ensure_ascii=False )

    print("Первая заметка успешно создана")