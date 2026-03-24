# Java-Spring-XML-2-Static 🚀

A local-first documentation engine built with **Java 25** and **Spring Boot 4**. This tool transforms structured XML data into a high-performance, searchable "Glass UI" static website.

## 🛠️ Tech Stack
* **Backend:** Java 25, Spring Boot, JAXB (XML Unmarshalling)
* **Frontend:** Thymeleaf, Bootstrap 5, Vanilla JS (Live Search)
* **Environment:** Developed on Linux Mint
* **Style:** Modern Glassmorphism (Backdrop-filter UI)

## 📖 How It Works
The "Beast" operates on a **Zero-Database** principle:
1. **Data Entry:** Drop `.xml` files into `src/main/resources/data/docs/`.
2. **Live Preview:** Run the Spring Boot app to view your searchable Knowledge Base at `localhost:8080`.
3. **Static Export:** Execute `generate-static.sh` to crawl the local app and generate a portable HTML/CSS site in the `/dist` folder.

## 🚀 Getting Started
1. Clone the repo.
2. Ensure you have **Java 25** installed (SDKMAN recommended).
3. Run `./mvnw spring-boot:run`.
4. Add your own technical docs to the XML data folder.

## 📜 Projects Featured
* **Hardware Diagnostic Tools:** Java-based thermal monitoring.
* **Energy Management:** Solar generator and power station configurations.
* **IT Audit Automation:** System integrity and compliance workflows.

---
*Built with precision and a touch of AI collaboration.*