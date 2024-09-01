import xml.etree.ElementTree as ET
import os 

# Define paths

xml_file = 'C:/Users/peter/Github/Chess-voice-recognition/chess_val.xml'
output_dir = 'C:/Users/peter/Github/Chess-voice-recognition/idkyet'
image_width = 821
image_height = 815

# Create output directory if it doesn't exisit
os.makedirs(output_dir, exist_ok=True)

# Parse the XML file
tree = ET.parse(xml_file)
root = tree.getroot()

def convert_class_name_to_id(name):
    class_mapping = {
        'black_rook': 0,
        'black_knight': 1,
        'black_bishop' : 2,
        'black_queen' : 3,
        'black_king' : 4,
        'black_pawn' : 5, 
        'white_rook' : 6,
        'white_knight' : 7,
        'white_bishop' : 8,
        'white_queen' : 9,
        'white_king' : 10,
        'white_pawn' : 11
    }
    return class_mapping[name]
#Open the output file 
output_file = os.path.join(output_dir, 'chess_val.txt')
with open(output_file,'w') as f:
    for object in root.findall('object'):
        name = object.find('name')
        name = name.text
        class_id = convert_class_name_to_id(name) #Define this function to map names to class IDS
        boundingbox = object.find('bndbox')
        xmin = int(boundingbox.find('xmin').text)
        ymin = int(boundingbox.find('ymin').text)
        xmax = int(boundingbox.find('xmax').text)
        ymax = int(boundingbox.find('ymax').text)
        
        #Normalize coordinates
        x_center = (xmin + xmax) / 2.0 / image_width
        y_center = (ymin + ymax) / 2.0 / image_height
        width = (xmax - xmin) / image_width
        height = (ymax - ymin) / image_height
        
        f.write(f"{class_id} {x_center} {y_center} {width} {height}\n" )
        
