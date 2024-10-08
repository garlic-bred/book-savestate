# Book Savestate
[Video Demonstration](https://youtu.be/tD6eCmdbPp0)\
\
Works in versions 1.20.5 to 1.21.1\
Patched in 24w33a (1.21.2 snapshot)\
Patched on paper

Credits to [Captain_S0L0](https://github.com/Captain-S0L0) for discovering the exploit

## Features
Adds 3 client-side commands: `/dupe`, `/savestate`, and `/chunkban`

### Inventory Savestate (Item Duping)
Instructions:
1. Put a book and quill in your main hand and all the items you want to dupe in your inventory.
2. Relog so your inventory gets saved.
3. Drop all the items you want to dupe or put them in a chest.
4. Run the `/dupe` command. You will be kicked from the server and your inventory will not be saved.
5. Log back in and repeat steps 3 and 4 until you are finished duping.

### Chunk Savestate
Instructions:
1. Put a book and quill in your main hand and a chest, barrel, or lectern in the chunk you want to savestate.
2. Build a chunk loader to load the chunk or have another account stand nearby.
3. Run the `/savestate` command and then right click on the chest/barrel/lectern. You will be kicked from the server and your inventory will not be saved.
4. The server will now be unable to save the chunk. You can now move items out of chests, mine blocks, etc.
5. When you want to revert the chunk to the last save just unload the chunk.

### Chunk Ban/Server Crash
Instructions:
1. Put a book and quill in your main hand.
2. Build a chunk loader to load the chunk you want to ban.
3. Run the `/chunkban` command while standing in the chunk you want to ban. You and all players around you will be kicked. Only your inventory will not be saved.
4. This will cause a server crash when the server tries to save the chunk.
