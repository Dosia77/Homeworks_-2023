import json

def sort_id():
    data = json.load(open("notes.json"))
    min=1
    for note in data['notes']:
        note['id'] = min
        min +=1
    with open("notes.json", "w") as file:
        json.dump(data, file,indent=4, ensure_ascii=False )