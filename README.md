# 📊 ServerStats – Мониторинг сервера Minecraft

Команда: `/serverstats`

---

## ✨ Возможности
🖥️ RAM: использовано / всего / максимум  
⚙️ CPU: точность 0.01%  
⏱️ TPS: тики в секунду  
🔍 Без зависимостей  
📈 Минимальная нагрузка

---

## ⚙️ Установка
📥 Скачать → 📂 plugins/ → 🔄 Перезапуск

---

## 📖 Использование
`/serverstats`

```
§aRAM: §f1024MB / 2048MB (макс. 4096MB)
§aCPU: §f23.45%
§aTPS: §f19.98
```

---

## 📊 Нормы
| Показатель | Норма |
|------------|-------|
| RAM        | <90%  |
| CPU        | <70%  |
| TPS        | 20.0 ок, <18 лаги |

---

## 🛠️ Особенности
✔ OperatingSystemMXBean для CPU  
✔ Bukkit API для TPS  
✔ Автоконвертация MB  
✔ Обработка ошибок (N/A)

---

## 📌 Требования
✅ Minecraft 1.12.2+  
✅ Bukkit / Spigot / Paper  
⚠️ Java 8+

---

## 🔄 Планы
📈 История  
🖼️ GUI  
🔔 Оповещения  
⚡ Folia

---

## 💻 Код
```
long usedMB = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
double cpuLoad = osBean.getSystemCpuLoad() * 100;
double tps = Bukkit.getTPS()[0];
```

**ServerStats** – всё под контролем! 🚀
