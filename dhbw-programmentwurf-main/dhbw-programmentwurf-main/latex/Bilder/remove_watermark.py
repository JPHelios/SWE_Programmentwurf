import sys
import re

def main():
    content = ""
    with open(sys.argv[1], "r") as f:
        content = f.read()
    reg = r"<text[^>]*>Visual Paradigm Standard[^<]*</text[^>]*>"
    content = re.sub(reg, "", content)
    with open(sys.argv[1], "w") as f:
        f.write(content)

if __name__ == '__main__':
    main()