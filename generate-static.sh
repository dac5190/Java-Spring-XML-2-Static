#!/bin/bash
TARGET_DIR="./dist"
SOURCE_XML_DIR="src/main/resources/data/docs"

echo "🛰️  Starting Intelligent Export..."

# 1. Grab the index
wget -q --header="X-Static-Export: true" -P $TARGET_DIR http://localhost:8080/index.html

# 2. Grab CSS
mkdir -p $TARGET_DIR/css
wget -q -P $TARGET_DIR/css http://localhost:8080/css/style.css

# 3. Dynamic Loop: Look at your XML files to know what to crawl
for file in "$SOURCE_XML_DIR"/*.xml; do
    # Get the filename without the extension (the ID)
    doc_id=$(basename "$file" .xml)
    
    echo "📄 Crawling: $doc_id"
    mkdir -p "$TARGET_DIR/docs/$doc_id"
    
    # Download the dynamic Spring page as a static index.html
    wget -q --header="X-Static-Export: true" \
         -O "$TARGET_DIR/docs/$doc_id/index.html" \
         "http://localhost:8080/docs/$doc_id"
done

echo "✅ Engine Export Complete. Everything in /dist is now a static site."