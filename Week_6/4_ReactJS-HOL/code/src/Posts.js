import React from 'react';
import Post from './Post';

class Posts extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      posts: [],
      hasError: false
    };
  }

  static getDerivedStateFromError(error) {
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    console.error("Error caught by componentDidCatch:", error, info);
    alert(`An error occurred: ${error.message}`);
  }

  async loadPosts() {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      const data = await response.json();
      const loadedPosts = data.map(post => new Post(post.id, post.title, post.body));
      this.setState({ posts: loadedPosts });
    } catch (error) {
      console.error("Error loading posts:", error);
      this.setState({ hasError: true }); 
    }
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}
export default Posts;