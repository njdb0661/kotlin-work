// COMP2850 Portfolio: Week 4
// ToDoList class

import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

class ToDoList() {
    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size
    val notStarted : Int 
        get() { // compute no. of items with NotStarted status
            var count = 0
            for (item in items) {
                if (item.status == ItemStatus.NotStarted) {
                    count = count + 1
                }
            }
            return count
        }   
    val inProgress : Int 
        get() { // compute no. of items with InProgress status
            var count = 0
            for (item in items) {
                if (item.status == ItemStatus.InProgress) {
                    count = count + 1
                }
            }
            return count
        }   
    val done : Int 
        get() { // compute no. of items with Done status
            var count = 0
            for (item in items) {
                if (item.status == ItemStatus.Done) {
                    count = count + 1
                }
            }
            return count
        }         
    val overdue : Int 
        get() { // compute no. of overdue items
            var count = 0
            val today = today()
            for (item in items) {
                if (item.dueDate < today && item.status != ItemStatus.Done) {
                    count = count + 1
                }
            }
            return count
        }      

    constructor(filename: String): this() {
        load(filename)
    }

    fun load(filename: String) {
        // Implement code to read To Do list from a file here
        // See data/to-do.csv for an example of the format
        val path = Path(filename)
        val lines = mutableListOf<String>()

        path.forEachLine {line -> lines.add(line)}

        for (line in lines) {
            val columns = line.split(":")

            val dueDate = LocalDate.parse(columns[0].trim())
            val status = ItemStatus.valueOf(columns[1].trim())
            val description = columns[2].trim()

            val item = ToDoItem(dueDate, status, description)
            items.add(item)
        }
    }

    fun save(filename: String) {
        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) = item.forEach { items.add(it) }

    fun deleteDone(): Boolean {
        // Write code here to remove items with status of Done
        // Return true if any were removed, false if none were removed
        return items.removeAll {item -> item.status == ItemStatus.Done}
    }

    fun getItems(status: ItemStatus? = null): List<ToDoItem> {
        // Write code here to return a list of items with the matching
        // status, or a list of all items if status argument is null
        val statusList = mutableListOf<ToDoItem>()
        
        if (status != null) {
            for (item in items) {
                if (item.status == status) {
                    statusList.add(item)
                }
            }
            return statusList
        }
        else {
            return items
        }
    }

    fun getItemsDueOn(date: LocalDate): List<ToDoItem> {
        // Write code here to return a list of items
        // that are due on the specified date
        val dueItems = mutableListOf<ToDoItem>()
        
        for (item in items) {
            if (item.dueDate == date) {
                dueItems.add(item)
            }
        }
        return dueItems
    }
}
