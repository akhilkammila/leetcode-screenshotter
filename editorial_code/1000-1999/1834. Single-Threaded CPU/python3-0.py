class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        # Sort based on min task processing time or min task index.
        next_task: List[Tuple[int, int]] = []
        tasks_processing_order: List[int] = []
        
        # Store task enqueue time, processing time, index.
        sorted_tasks = [(enqueue, process, idx) for idx, (enqueue, process) in enumerate(tasks)]
        sorted_tasks.sort()
        
        curr_time = 0
        task_index = 0
        
        # Stop when no tasks are left in array and heap.
        while task_index < len(tasks) or next_task:
            if not next_task and curr_time < sorted_tasks[task_index][0]:
                # When the heap is empty, try updating curr_time to next task's enqueue time. 
                curr_time = sorted_tasks[task_index][0]
            
            # Push all the tasks whose enqueueTime <= currtTime into the heap.
            while task_index < len(sorted_tasks) and curr_time >= sorted_tasks[task_index][0]:
                _, process_time, original_index = sorted_tasks[task_index]
                heapq.heappush(next_task, (process_time, original_index))
                task_index += 1
            
            process_time, index = heapq.heappop(next_task)
            
            # Complete this task and increment curr_time.
            curr_time += process_time
            tasks_processing_order.append(index)
        
        return tasks_processing_order