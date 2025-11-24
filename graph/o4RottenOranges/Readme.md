📘 ROTTEN ORANGES — REVISION NOTES (BFS PATTERN)
⭐ 1. Problem Understanding (Simple)

Grid contains:

0 → empty cell

1 → fresh orange

2 → rotten orange

Every 1 minute, rotten oranges infect adjacent (4-direction) fresh ones.

Goal:

Find minimum minutes required to rot all fresh oranges.
If some fresh oranges never rot → return -1.

⭐ 2. Why Use BFS? (Important Concept)

Rotten oranges infect neighbors level by level, like waves:

Minute 0 → initial rotten oranges

Minute 1 → oranges adjacent to them rot

Minute 2 → oranges adjacent to those rot

And so on…

This is exactly how BFS works (first level → second level → third level)

Therefore:

Rotten Oranges = Multi-Source BFS problem.

⭐ 3. Multi-Source BFS Concept (VERY IMPORTANT)

Usually BFS starts from one starting point.

Here:

There might be many rotten oranges initially.

All of them spread rot at the same time.

So:

We push all rotten oranges into the queue at the beginning.

This is called Multi-Source BFS.

⭐ 4. Why does the Pair store 3 things — (row, col, time)?
✔ row → position
✔ col → position
✔ time → minute when this orange became rotten

Without storing time, BFS cannot tell:

when an orange rotted

how many minutes total passed

when the next rot wave happens

Time = BFS level number
which represents the minute of infection.

⭐ 5. Why Only 4 Directions?

Fresh oranges rot only by sharing an edge:

UP    → (-1,0)
DOWN  → (1,0)
LEFT  → (0,-1)
RIGHT → (0,1)


Diagonal infection is NOT allowed.

⭐ 6. BFS APPROACH (STEP-BY-STEP)
🔹 Step 1: Count fresh oranges

So you know how many must rot.

🔹 Step 2: Push ALL rotten oranges into queue

Each with:

time = 0

🔹 Step 3: BFS

For each orange popped:

Try all 4 directions

If neighbor is fresh → rot it

Set time = current time + 1

Push into queue

🔹 Step 4: Track maximum time seen

This becomes the final result.

🔹 Step 5: After BFS

If any fresh orange is left → return -1

Else return total minutes.

⭐ 8. Most Important Things to Remember
✔ Use multi-source BFS

(all initial rotten oranges in queue)

✔ Store time (BFS level) inside Pair

So you know which minute each got infected.

✔ Only 4 directions

Not diagonals.

✔ After BFS, if fresh > 0 → return -1
✔ BFS is ALWAYS used when:

Something spreads layer-by-layer

Something happens "each minute"

Something expands outward (infection, fire, water, waves)

⭐ 9. Pattern to Use in Future Grid Problems

This pattern works for:

Fire spreading

Water flooding

Distance to nearest 1

Walls and gates

Nearest exit in maze

Multi-source shortest path problems

Whenever something spreads over time → Multi-Source BFS.
