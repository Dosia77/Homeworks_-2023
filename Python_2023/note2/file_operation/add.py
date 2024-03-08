from datetime import datetime
import json
from file_operation.sort import sort_id

def add_notes():
    sort_id()
    data = json.load(open("notes.json")) 
    timestamp = datetime.now().strftime('%Y-%m-%d')#№ %H:%M:%S')
    note_id = (len(data['notes']) + 1 )
    note_title = input("Введите заголовок заметки: ")

    note_body = input("Введите текст заметки: ")
    new_data = {"id": note_id,
                "title": note_title,
                "body": note_body,
                "timestamp": timestamp
                }
    
    data['notes'].append(new_data)

    with open("notes.json", "w") as file:

        json.dump(data, file,indent=4, ensure_ascii=False )
