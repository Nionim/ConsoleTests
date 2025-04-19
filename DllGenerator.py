import os, platform, subprocess, sys

os_name = platform.system()

source_dir = sys.argv[1]
output_dir = sys.argv[2]
java_home = sys.argv[3]

# TODO
# javac -h . delta/cion/Main.java

files = [f for f in os.listdir(source_dir) if f.endswith('.c')]

cmds = {
    "Windows": lambda raw_file: [
        "gcc", "-shared", "-o", f"{output_dir.replace(os.sep, '/')}/{raw_file.replace('.c', '.dll')}", 
        f"{source_dir.replace(os.sep, '/')}/{raw_file}", 
        f"-I{java_home.replace(os.sep, '/')}/include", 
        f"-I{java_home.replace(os.sep, '/')}/include/win32"
    ],
    "Linux": lambda raw_file: [
        "gcc", "-shared", "-o", f"{output_dir}/{raw_file.replace('.c', '.dll')}", 
        f"{source_dir}/{raw_file}", 
        f"-I{java_home}/include"
    ],
    "Darwin": lambda raw_file: cmds["Linux"](raw_file)
}

class DllsGenerator():
    def __init__(self):
        if not os.path.exists(output_dir):
            os.makedirs(output_dir)
        for raw_file in files:
            command = cmds[os_name](raw_file)
            subprocess.run(command, cwd="./")

DllsGenerator()